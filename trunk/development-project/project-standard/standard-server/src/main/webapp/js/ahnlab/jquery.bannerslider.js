/**
 * SlideShow jQuery Plugin
 * - USAGE: $(selector).bannerslider();
 */
(function(MODULES, $, undefined) {
    "use strict";
    var NAMESPACE = 'namespace.bannerslider';

    /*
     * ================================================================================
     * BannerSlider
     * ================================================================================
     */
    /**
     * 생성자
     * @class BannerSlider
     * @param {Mixed} container 컨텐이너
     */
    function BannerSlider(container, options) {
        this.options = $.extend({
            listSelector: 'ul',
            targetSelector: null,
            bulletSelector: 'button.cir',
            autoSelector: 'button.anim',
            moveHorizontal: true,
            moveEasing: 'swing',
            moveDuration: 1000,
            moveSync: false,
            autoInterval: 5000
        }, options);

        this.$container = $(document.getElementById(container) || container);
        this.$list = this.$container.find(this.options.listSelector);
        this.$items = this.$list.children();
        this.$targets = this.options.targetSelector ? this.$list.find(this.options.targetSelector) : this.$items;
        this.$bullets = this.$container.find(this.options.bulletSelector);
        this.$auto = this.$container.find(this.options.autoSelector);

        this.size = this.$items.length;
        this.direction = this.options.moveHorizontal ? 'left' : 'top';
        this.distance = this.$targets.eq(0)[this.options.moveHorizontal ? 'outerWidth' : 'outerHeight']();
        this.index = -1;
        this.start = 0;
        this.timer = null;
        this.stopped = false;
        this.hovered = false;

        this.$container.css('overflow', 'hidden');
        this.$container.prop('index', this.index);
        if (/absolute|relative|fixed/.test(this.$targets.css('position')) === false) {
            this.$list.css('position', 'relative');
            this.$targets.css('position', 'absolute');
        }

        this._createDummy();
        this._bindEvent();
        this.move(0, true);
    }

    BannerSlider.prototype = {
        /**
         * 더미 생성
         * @private
         * @function
         */
        _createDummy: function() {
            this.$container.remove('.d-bannerslide-dummy');

            if (this.size > 1) {
                var $head = this.$items.last().clone().addClass('d-bannerslide-dummy').removeClass('on'),
                    $tail = this.$items.first().clone().addClass('d-bannerslide-dummy').removeClass('on');

                $head.find(this.options.bulletSelector).remove();
                $tail.find(this.options.bulletSelector).remove();

                this.$items.first().before($head);
                this.$items.last().after($tail);

                this.$targets = this.options.targetSelector ? this.$list.find(this.options.targetSelector) : this.$list.children();
                this.start = -1;
            }
        },
        /**
         * 이벤트 등록
         * @private
         * @function
         */
        _bindEvent: function() {
            var self = this;

            this.$container.off('.' + NAMESPACE);

            if (this.options.moveSync) {
                $(document).on('sync.' + this.options.moveSync + '.' + NAMESPACE, function(event) {
                    if (!self.stopped && !self.hovered) {
                        self.next();
                    }
                });
            }

            this.$container.on('mouseenter.' + NAMESPACE + ', mouseleave.' + NAMESPACE, function(event) {
                if (event.type === 'mouseenter') {
                    self.hovered = true;
                    self.stop(true);
                } else {
                    self.hovered = false;
                    self.play(true);
                }
            });

            this.$container.on('click.' + NAMESPACE, this.options.bulletSelector, function(event) {
                self.move(self.$bullets.index(this));
            });

            this.$container.on('click.' + NAMESPACE, this.options.autoSelector, function(event) {
                self.toggle();
            });
        },
        /**
         * 갱신
         * @private
         * @function
         */
        update: function() {
            var sel = (this.size + (this.index % this.size)) % this.size;

            this.$items.removeClass('on');
            this.$items.eq(sel).addClass('on');
        },
        /**
         * 이동
         * @function
         * @param {Number} idx 인덱스
         * @param {Boolean} [immediately=false] 즉시 여부
         */
        move: function(idx, immediately) {
            var self = this,
                opts = this.options,
                sel = (this.size + (idx % this.size)) % this.size,
                len = this.$targets.length;

            if (sel !== this.index) {
                this.index = idx;
                this.update();
                this.stop(true);

                this.$container.stop(true).animate({ index: idx }, {
                    easing: opts.moveEasing,
                    duration: immediately ? 0 : opts.moveDuration,
                    step: function(now, tween) {
                        var i, p;

                        now = now % self.size;
                        if (now <= -1) {
                            now += self.size;
                        }

                        for (i = 0; i < len; i += 1) {
                            p = (i - now + self.start) * self.distance;

                            self.$targets.eq(i).css(self.direction, p);
                        }
                    },
                    complete: function() {
                        self.index = sel;
                        self.$container.prop('index', sel);
                        self.play(true);
                    }
                });
            }
        },
        /**
         * 이전
         * @function
         */
        prev: function() {
            if (this.index !== -1) {
                this.move(this.index - 1);
            }
        },
        /**
         * 다음
         * @function
         */
        next: function() {
            if (this.index !== -1) {
                this.move(this.index + 1);
            }
        },
        /**
         * 재생
         * @function
         * @param {Boolean} [resume=false] 다시 시작 여부
         */
        play: function(resume) {
            var self = this;

            clearTimeout(this.timer);
            this.timer = null;

            if (this.size && this.options.autoInterval > 0) {
                if (!resume) {
                    this.stopped = false;
                    this.$auto.removeClass('play').addClass('stop');
                    this.$auto.children().text(this.autoStopText);
                }

                if (!this.stopped && !this.hovered) {
                    this.timer = setTimeout(function() {
                        if (self.options.moveSync) {
                            $(document).trigger('sync.' + self.options.moveSync + '.' + NAMESPACE);
                        } else {
                            self.next();
                        }
                    }, this.options.autoInterval);
                }
            }
        },
        /**
         * 정지
         * @function
         * @param {Boolean} [pause=false] 일시 정지 여부
         */
        stop: function(pause) {
            clearTimeout(this.timer);
            this.timer = null;

            if (!pause) {
                this.stopped = true;
                this.$auto.removeClass('stop').addClass('play');
                this.$auto.children().text(this.autoPlayText);
            }
        },
        /**
         * 재생/정지 토글
         * @function
         */
        toggle: function() {
            if (this.stopped) {
                this.play();
            } else {
                this.stop();
            }
        }
    };
    
    /*
     * ================================================================================
     * 전역 변수 및 jQuery 플러그인 등록
     * ================================================================================
     */
    $.fn.bannerslider = function(method) {
        var args = Array.prototype.slice.call(arguments, 1);

        return this.each(function() {
            var $this = $(this),
                module = $this.data(NAMESPACE);

            if (!module) {
                $this.data(NAMESPACE, new BannerSlider($this, method));
            } else if (module[method]) {
                module[method].apply(module, args);
            } else {
                $.error('method does not exists');
            }
        });
    }

})({}, jQuery);
