package uz.shohjahon.mvi.framework.datasourse.network.model.response

import uz.shohjahon.mvi.framework.datasourse.network.model.ArticleDto

data class NewsResponse(
    val articles: List<ArticleDto>,
    val status: String,
    val totalResults: Int
)