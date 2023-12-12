package com.ama.springboot.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * InlineResponse2001
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-12-12T18:50:24.325627535Z[GMT]")


public class InlineResponse2001   {
  @JsonProperty("content")
  @Valid
  private List<Produto> content = null;

  @JsonProperty("totalPages")
  private Integer totalPages = null;

  @JsonProperty("totalElements")
  private Integer totalElements = null;

  @JsonProperty("last")
  private Boolean last = null;

  @JsonProperty("size")
  private Integer size = null;

  @JsonProperty("number")
  private Integer number = null;

  @JsonProperty("sort")
  private Object sort = null;

  public InlineResponse2001 content(List<Produto> content) {
    this.content = content;
    return this;
  }

  public InlineResponse2001 addContentItem(Produto contentItem) {
    if (this.content == null) {
      this.content = new ArrayList<Produto>();
    }
    this.content.add(contentItem);
    return this;
  }

  /**
   * Get content
   * @return content
   **/
  @Schema(description = "")
      @Valid
    public List<Produto> getContent() {
    return content;
  }

  public void setContent(List<Produto> content) {
    this.content = content;
  }

  public InlineResponse2001 totalPages(Integer totalPages) {
    this.totalPages = totalPages;
    return this;
  }

  /**
   * Get totalPages
   * @return totalPages
   **/
  @Schema(description = "")
  
    public Integer getTotalPages() {
    return totalPages;
  }

  public void setTotalPages(Integer totalPages) {
    this.totalPages = totalPages;
  }

  public InlineResponse2001 totalElements(Integer totalElements) {
    this.totalElements = totalElements;
    return this;
  }

  /**
   * Get totalElements
   * @return totalElements
   **/
  @Schema(description = "")
  
    public Integer getTotalElements() {
    return totalElements;
  }

  public void setTotalElements(Integer totalElements) {
    this.totalElements = totalElements;
  }

  public InlineResponse2001 last(Boolean last) {
    this.last = last;
    return this;
  }

  /**
   * Get last
   * @return last
   **/
  @Schema(description = "")
  
    public Boolean isLast() {
    return last;
  }

  public void setLast(Boolean last) {
    this.last = last;
  }

  public InlineResponse2001 size(Integer size) {
    this.size = size;
    return this;
  }

  /**
   * Get size
   * @return size
   **/
  @Schema(description = "")
  
    public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }

  public InlineResponse2001 number(Integer number) {
    this.number = number;
    return this;
  }

  /**
   * Get number
   * @return number
   **/
  @Schema(description = "")
  
    public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  public InlineResponse2001 sort(Object sort) {
    this.sort = sort;
    return this;
  }

  /**
   * Get sort
   * @return sort
   **/
  @Schema(description = "")
  
    public Object getSort() {
    return sort;
  }

  public void setSort(Object sort) {
    this.sort = sort;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse2001 inlineResponse2001 = (InlineResponse2001) o;
    return Objects.equals(this.content, inlineResponse2001.content) &&
        Objects.equals(this.totalPages, inlineResponse2001.totalPages) &&
        Objects.equals(this.totalElements, inlineResponse2001.totalElements) &&
        Objects.equals(this.last, inlineResponse2001.last) &&
        Objects.equals(this.size, inlineResponse2001.size) &&
        Objects.equals(this.number, inlineResponse2001.number) &&
        Objects.equals(this.sort, inlineResponse2001.sort);
  }

  @Override
  public int hashCode() {
    return Objects.hash(content, totalPages, totalElements, last, size, number, sort);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse2001 {\n");
    
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    totalPages: ").append(toIndentedString(totalPages)).append("\n");
    sb.append("    totalElements: ").append(toIndentedString(totalElements)).append("\n");
    sb.append("    last: ").append(toIndentedString(last)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    sort: ").append(toIndentedString(sort)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
