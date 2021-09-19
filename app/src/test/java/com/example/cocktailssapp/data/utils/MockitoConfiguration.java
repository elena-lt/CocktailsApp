package com.example.cocktailssapp.data.utils;

import org.mockito.configuration.DefaultMockitoConfiguration;
import org.mockito.internal.stubbing.defaultanswers.ReturnsEmptyValues;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public class MockitoConfiguration extends DefaultMockitoConfiguration {

    public Answer<Object> getDefaultAnswer(){
        return new ReturnsEmptyValues(){
            @Override
            public Object answer(InvocationOnMock invocation) {
                Class<?> type = invocation.getMethod().getReturnType();
                if (type.isAssignableFrom(Observable.class)) {
                    return Observable.error(createException(invocation));
                } else if (type.isAssignableFrom(Single.class)) {
                    return Single.error(createException(invocation));
                } else {
                    return super.answer(invocation);
                }
            }
        };
    }

    @NonNull
    private RuntimeException createException(
            InvocationOnMock invocation) {
        String s = invocation.toString();
        return new RuntimeException(
                "No mock defined for invocation " + s);
    }
}
