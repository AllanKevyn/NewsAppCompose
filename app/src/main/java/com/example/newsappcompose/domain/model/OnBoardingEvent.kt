package com.example.newsappcompose.domain.model

sealed class OnBoardingEvent{

    data object SaveAppEntry: OnBoardingEvent()

}
