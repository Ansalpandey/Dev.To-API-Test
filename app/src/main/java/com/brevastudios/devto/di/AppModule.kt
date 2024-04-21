package com.brevastudios.devto.di

import com.brevastudios.devto.datalayer.ArticleDataSource
import com.brevastudios.devto.datalayer.ArticleRepository
import com.brevastudios.devto.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dev.to/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    fun provideDataSource(apiService: ApiService): ArticleDataSource {
        return ArticleDataSource(apiService)
    }
    @Provides
    fun provideMovieRepository(movieDataSource: ArticleDataSource) : ArticleRepository {
        return ArticleRepository(movieDataSource)
    }
}