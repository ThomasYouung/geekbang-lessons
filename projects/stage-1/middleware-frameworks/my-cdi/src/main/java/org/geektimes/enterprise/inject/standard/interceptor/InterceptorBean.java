/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.geektimes.enterprise.inject.standard.interceptor;

import org.geektimes.enterprise.inject.standard.AbstractAnnotatedTypeBean;
import org.geektimes.interceptor.InterceptorBindings;
import org.geektimes.interceptor.InterceptorInfo;
import org.geektimes.interceptor.InterceptorManager;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.*;
import javax.interceptor.InvocationContext;
import java.lang.annotation.Annotation;
import java.util.Set;

import static org.geektimes.interceptor.InterceptorManager.getInstance;

/**
 * {@link Interceptor} Bean Implementation
 *
 * @param <T> the interceptor bean class
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @since 1.0.0
 */
public class InterceptorBean<T> extends AbstractAnnotatedTypeBean<T> implements Interceptor<T> {

    private final AnnotatedType<?> interceptorType;

    private final Class<?> interceptorClass;

    private final InterceptorManager interceptorManager;

    private final InterceptorInfo interceptorInfo;

    private final BeanManager beanManager;

    public InterceptorBean(AnnotatedType<T> interceptorType, BeanManager beanManager) {
        super(interceptorType);
        this.interceptorType = interceptorType;
        this.interceptorClass = interceptorType.getJavaClass();
        this.interceptorManager = getInstance(interceptorClass.getClassLoader());
        this.interceptorManager.registerInterceptorClass(interceptorClass);
        this.interceptorInfo = interceptorManager.getInterceptorInfo(interceptorClass);
        this.beanManager = beanManager;
    }

    @Override
    public Set<Annotation> getInterceptorBindings() {
        // TODO
        return null;
    }

    @Override
    public boolean intercepts(InterceptionType type) {
        // TODO
        return false;
    }

    @Override
    public Object intercept(InterceptionType type, T instance, InvocationContext ctx) throws Exception {
        // TODO
        return null;
    }

    @Override
    public Set<InjectionPoint> getInjectionPoints() {
        // TODO
        return null;
    }

    @Override
    public T create(CreationalContext<T> creationalContext) {
        // TODO
        return null;
    }

    @Override
    public void destroy(T instance, CreationalContext<T> creationalContext) {
        // TODO
    }

    @Override
    protected String getBeanName(Class interceptorClass) {
        // TODO
        return null;
    }

    @Override
    protected void validateAnnotatedElement(Class interceptorClass) {
        // TODO
    }

    @Override
    public Annotated getAnnotated() {
        // TODO
        return interceptorType;
    }
}