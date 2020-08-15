package com.java8.adv.reflector;

import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import com.java8.adv.reflect.Reflects;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public enum Proxies {
	/**
	 * jdk代理实现
	 */
	JDK_PROXY(new ProxyDelegate() {
		@Override
		public <T> T newProxy(Class<T> interfaceType, Object handler) {
//			checkArgument(handler instanceof InvocationHandler,
//					"handler must be a InvocationHandler");
			Object object = Proxy.newProxyInstance(
					interfaceType.getClassLoader(),
					new Class<?>[] { interfaceType },
					(InvocationHandler) handler);
			return interfaceType.cast(object);
		}
	}), ASSIT(new ProxyDelegate() {
		@Override
		public <T> T newProxy(Class<T> interfaceType, Object handler) {
//			checkArgument(handler instanceof MethodHandler,
//					"handler must be a MethodHandler");
			ProxyFactory proxyFactory = new ProxyFactory();
			proxyFactory.setInterfaces(new Class[] { interfaceType });
			Class c = proxyFactory.createClass();
			Object result = Reflects.newInstance(c);
			((ProxyObject) result).setHandler((MethodHandler) handler);
			return interfaceType.cast(result);
		}
	}), CGLIB(new ProxyDelegate() {
		@Override
		public <T> T newProxy(Class<T> interfaceType, Object handler) {
//			checkArgument(handler instanceof MethodInterceptor,
//					"handler must be a MethodInterceptor");
//			Enhancer enhancer = new Enhancer();
//			enhancer.setCallback((Callback) handler);
//			enhancer.setInterfaces(new Class[] { interfaceType });
//			Object result = enhancer.create();
//			return interfaceType.cast(result);
			return null;
		}
	}), BYTE_BUDDY_PROXY(new ProxyDelegate() {
		@Override
		public <T> T newProxy(Class<T> interfaceType, Object handler) {
			Class<? extends T> cls = new ByteBuddy()
					.subclass(interfaceType)
					.method(ElementMatchers.isDeclaredBy(interfaceType))
					.intercept(MethodDelegation.to(handler, "handler"))
					.make()
					.load(interfaceType.getClassLoader(),
							ClassLoadingStrategy.Default.INJECTION).getLoaded();
			return Reflects.newInstance(cls);
		}
	});

	private ProxyDelegate delegate;

	Proxies(ProxyDelegate delegate) {
		this.delegate = delegate;
	}

	public <T> T newProxy(Class<T> interfaceType, Object handler) {
		return delegate.newProxy(interfaceType, handler);
	}

	interface ProxyDelegate {

		/**
		 * Returns a proxy instance that implements {@code interfaceType} by
		 * dispatching method invocations to {@code handler}. The class loader
		 * of {@code interfaceType} will be used to define the proxy class.
		 */
		<T> T newProxy(Class<T> interfaceType, Object handler);
	}
}