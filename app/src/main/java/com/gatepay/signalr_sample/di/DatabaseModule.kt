package com.gatepay.signalr_sample.di

import android.content.Context
import androidx.room.Room
import com.gatepay.signalr_sample.common.DB_NAME
import com.gatepay.signalr_sample.data.data_source.local.AppDatabase
import com.gatepay.signalr_sample.data.data_source.local.LoginDao
import com.gatepay.signalr_sample.data.repository.DatabaseRepositoryImpl
import com.gatepay.signalr_sample.domain.repository.DatabaseRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext application: Context): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, DB_NAME)
            .allowMainThreadQueries().build()
    }


    @Singleton
    @Provides
    fun provideLoginDao(db: AppDatabase) = db.loginDao()


    @Provides
    @Singleton
    fun provideDatabaseRepository(loginDao: LoginDao): DatabaseRepository =
        DatabaseRepositoryImpl(loginDao)
}