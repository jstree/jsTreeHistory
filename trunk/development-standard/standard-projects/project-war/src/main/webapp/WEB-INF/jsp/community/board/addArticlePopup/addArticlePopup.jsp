<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" autoFlush="true"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%@ taglib tagdir="/WEB-INF/tags" prefix="customTags"%>

<!DOCTYPE html> 
<html lang="ko-KR">
<head>
<style>
</style>

<!-- JavaScript neccessary for the tree -->
<script type="text/javascript">
// <![CDATA[
$(document).ready(function($){

});
// ]]>
</script>
</head> 

<body id="demo_body">
	<div class="spr-container">
  <div class="spr-header">
    <h2 class="spr-header-title">Customer Reviews</h2>

    <div class="spr-summary" itemscope="" itemtype="http://data-vocabulary.org/Review-aggregate">
      <meta itemprop="itemreviewed" content="">
      <meta itemprop="votes" content="0">
      
      <span itemprop="rating" itemscope="" itemtype="http://data-vocabulary.org/Rating" class="spr-starrating spr-summary-starrating">
        <meta itemprop="average" content="0.0">
        <meta itemprop="best" content="5">
        <meta itemprop="worst" content="1">
        <i class="spr-icon spr-icon-star-empty" style=""></i><i class="spr-icon spr-icon-star-empty" style=""></i><i class="spr-icon spr-icon-star-empty" style=""></i><i class="spr-icon spr-icon-star-empty" style=""></i><i class="spr-icon spr-icon-star-empty" style=""></i>
      </span>
      <span class="spr-summary-caption">
        
          No reviews yet
        
      </span>
      <span class="spr-summary-actions">
        <a href="#" class="spr-summary-actions-newreview" onclick="SPR.toggleForm(318818187);return false">Write a review</a>
      </span>
    </div>
  </div>

  <div class="spr-content">
    <div class="spr-form" id="form_318818187" style=""><form method="post" action="//productreviews.shopifycdn.com/api/reviews/create" id="new-review-form_318818187" class="new-review-form" onsubmit="SPR.submitForm(this);return false;"><input type="hidden" name="review[rating]"><input type="hidden" name="product_id" value="318818187">

  <h3 class="spr-form-title">Write a review</h3>

  

    
    
      

      

      <fieldset class="spr-form-contact">

        
          <div class="spr-form-contact-name">
            <label class="spr-form-label" for="review_author_318818187">Name</label>
            <input class="spr-form-input spr-form-input-text " id="review_author_318818187" type="text" name="review[author]" value="" placeholder="Enter your name">
          </div>
        

        
          <div class="spr-form-contact-email">
            <label class="spr-form-label" for="review_email_318818187">Email</label>
            <input class="spr-form-input spr-form-input-email " id="review_email_318818187" type="email" name="review[email]" value="" placeholder="john.smith@example.com">
          </div>
        

        
      </fieldset>


      <fieldset class="spr-form-review">

        <div class="spr-form-review-rating">
          <label class="spr-form-label" for="review[rating]">Rating</label>
          <div class="spr-form-input spr-starrating ">
            <a href="#" onclick="SPR.setRating(this);return false;" class="spr-icon spr-icon-star spr-icon-star-empty" data-value="1">&nbsp;</a>
            <a href="#" onclick="SPR.setRating(this);return false;" class="spr-icon spr-icon-star spr-icon-star-empty" data-value="2">&nbsp;</a>
            <a href="#" onclick="SPR.setRating(this);return false;" class="spr-icon spr-icon-star spr-icon-star-empty" data-value="3">&nbsp;</a>
            <a href="#" onclick="SPR.setRating(this);return false;" class="spr-icon spr-icon-star spr-icon-star-empty" data-value="4">&nbsp;</a>
            <a href="#" onclick="SPR.setRating(this);return false;" class="spr-icon spr-icon-star spr-icon-star-empty" data-value="5">&nbsp;</a>
          </div>
        </div>

        <div class="spr-form-review-title">
          <label class="spr-form-label" for="review_title_318818187">Review Title</label>
          <input class="spr-form-input spr-form-input-text " id="review_title_318818187" type="text" name="review[title]" value="" placeholder="Give your review a title">
        </div>

        <div class="spr-form-review-body">
          <label class="spr-form-label" for="review_body_318818187">Body of Review <span class="spr-form-review-body-charactersremaining">(1500)</span></label>
          <div class="spr-form-input">
            <textarea class="spr-form-input spr-form-input-textarea " id="review_body_318818187" data-product-id="318818187" name="review[body]" rows="10" placeholder="Write your comments here"></textarea>
          </div>
        </div>
      </fieldset>

      <fieldset class="spr-form-actions">
        <input type="submit" class="spr-button spr-button-primary button button-primary btn btn-primary" value="Submit Review">
      </fieldset>
    
  
</form>
</div>
    <div class="spr-reviews" id="reviews_318818187" style="display: none">

  

  


</div>
  </div>

</div>
</body>
</html> 