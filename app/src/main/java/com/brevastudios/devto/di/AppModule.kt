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


/**
 * A Dagger module that provides dependencies for the application.
 */
@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    /**
     * Provides a Retrofit instance.
     *
     * @return A Retrofit instance.
     */
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dev.to/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    /**
     * Provides an ApiService instance.
     *
     * @param retrofit A Retrofit instance.
     * @return An ApiService instance.
     */
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    /**
     * Provides an com.brevastudios.devto.datalayer.ArticleDataSource instance.
     *
     * @param apiService An ApiService instance.
     * @return An com.brevastudios.devto.datalayer.ArticleDataSource instance.
     */
    @Provides
    fun provideDataSource(apiService: ApiService): ArticleDataSource {
        return ArticleDataSource(apiService)
    }

    /**
     * Provides an ArticleRepository instance.
     *
     * @param movieDataSource An com.brevastudios.devto.datalayer.ArticleDataSource instance.
     * @return An ArticleRepository instance.
     */
    @Provides
    fun provideMovieRepository(movieDataSource: ArticleDataSource) : ArticleRepository {
        return ArticleRepository(movieDataSource)
    }
}