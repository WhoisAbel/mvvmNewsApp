package com.example.mvvmNewsApp.repositories

import com.example.mvvmNewsApp.api.RetrofitInstance
import com.example.mvvmNewsApp.db.ArticleDatabase
import com.example.mvvmNewsApp.models.Article
import com.example.mvvmNewsApp.models.NewsResponse
import retrofit2.Response

class NewsRepository(
    val db: ArticleDatabase
) {

    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun getSearch(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) = db.articleDao().upsert(article)

    suspend fun deleteArticle(article: Article) = db.articleDao().deleteArticle(article)

    fun getAllArticles() = db.articleDao().getAllArticles()

}