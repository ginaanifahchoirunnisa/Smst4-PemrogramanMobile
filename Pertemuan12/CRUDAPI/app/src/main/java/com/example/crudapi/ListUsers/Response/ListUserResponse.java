
package com.example.crudapi.ListUsers.Response;

import java.util.List;

import com.example.crudapi.ListUsers.DataItem.DataItemList;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class ListUserResponse {

    @SerializedName("data")
    private List<DataItemList> mData;
    @SerializedName("page")
    private Long mPage;
    @SerializedName("per_page")
    private Long mPerPage;
    @SerializedName("total")
    private Long mTotal;
    @SerializedName("total_pages")
    private Long mTotalPages;

    public List<DataItemList> getData() {
        return mData;
    }

    public void setData(List<DataItemList> data) {
        mData = data;
    }

    public Long getPage() {
        return mPage;
    }

    public void setPage(Long page) {
        mPage = page;
    }

    public Long getPerPage() {
        return mPerPage;
    }

    public void setPerPage(Long perPage) {
        mPerPage = perPage;
    }

    public Long getTotal() {
        return mTotal;
    }

    public void setTotal(Long total) {
        mTotal = total;
    }

    public Long getTotalPages() {
        return mTotalPages;
    }

    public void setTotalPages(Long totalPages) {
        mTotalPages = totalPages;
    }

}
