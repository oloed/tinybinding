/*
Copyright © 2010-2011 Philipp Eichhorn.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
*/
package de.fips.util.tinybinding.util;

import java.util.HashMap;
import java.util.Map;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Collection of useful reflection methods.
 *
 * @author Philipp Eichhorn
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Reflection {
	private static final Map<Class<?>, Class<?>> wrapperToPrimitive = new HashMap<Class<?>, Class<?>>();

	static {
		wrapperToPrimitive.put(Boolean.class, Boolean.TYPE);
		wrapperToPrimitive.put(Byte.class, Byte.TYPE);
		wrapperToPrimitive.put(Character.class, Character.TYPE);
		wrapperToPrimitive.put(Short.class, Short.TYPE);
		wrapperToPrimitive.put(Integer.class, Integer.TYPE);
		wrapperToPrimitive.put(Long.class, Long.TYPE);
		wrapperToPrimitive.put(Float.class, Float.TYPE);
		wrapperToPrimitive.put(Double.class, Double.TYPE);
		wrapperToPrimitive.put(Void.class, Void.TYPE);
	}

	public static <T, S> Class<T> getPrimitive(final Class<S> clazz) {
		if (clazz == null) return null;
		return Cast.<Class<T>>uncheckedCast(wrapperToPrimitive.get(clazz));
	}

	public static boolean hasPrimitive(final Class<?> clazz) {
		if (clazz == null) return false;
		return wrapperToPrimitive.containsKey(clazz);
	}
}
