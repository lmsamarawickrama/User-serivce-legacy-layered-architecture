package org.saliam.smartbids.dto.common;

import java.util.Iterator;
import java.util.List;

public class PageDto<T extends PageableDto> implements Iterable<T> {
  private List<T> content;
  private long totalPages;
  private int pageNumber;

  public PageDto() {
    this(null, 0, 0);
  }

  public PageDto(List<T> content, int pageNumber, long totalPages) {
    setContent(content);
    setTotalPages(totalPages);
    setPageNumber(pageNumber);
  }

  public List<T> getContent() {
    return content;
  }

  public void setContent(List<T> content) {
    this.content = content;
  }

  public long getTotalPages() {
    return totalPages;
  }

  public void setTotalPages(long totalPages) {
    this.totalPages = totalPages;
  }

  public int getPageNumber() {
    return pageNumber;
  }

  public void setPageNumber(int pageNumber) {
    this.pageNumber = pageNumber;
  }

  @Override
  public Iterator<T> iterator() {
    return content.iterator();
  }
}
