package uz.shohjahon.mvi.di

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.shohjahon.mvi.framework.datasourse.network.abstraction.NewsService
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideNewsService(client: OkHttpClient): NewsService {
        return Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .client(client)
            .build()
            .create(NewsService::class.java)
    }

    @Provides
    fun provideHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        return builder.build()
    }


    @Singleton
    @Provides
    @Named("api_key")
    fun provideApiKey(): Pair<String, String> {
        return Pair("api_key", "7e9d750a048246cea6c3fa00b9b18a85")
    }
}