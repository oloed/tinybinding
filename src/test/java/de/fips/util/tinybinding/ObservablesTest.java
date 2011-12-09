/*
 * Copyright © 2010-2011 Philipp Eichhorn.
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package de.fips.util.tinybinding;

import static de.fips.util.tinybinding.Observables.observe;
import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.*;

import java.awt.Container;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import de.fips.util.tinybinding.impl.Observable;
import de.fips.util.tinybinding.pojo.PojoObservable;
import de.fips.util.tinybinding.swing.SwingObservable;

/**
 * Tests {@link Observables}.
 */
@RunWith(JUnit4.class)
public class ObservablesTest {

	@Test
	public void test_observeContainerCreatesSwingObservable() {
		assertThat(observe(mock(Container.class))).isInstanceOf(SwingObservable.class);
	}

	@Test
	public void test_observeObjectCreatesPojoObservable() {
		assertThat(observe(mock(Object.class))).isInstanceOf(PojoObservable.class);
	}

	@Test
	public void test_observeCreatesObservable() {
		assertThat(observe()).isInstanceOf(Observable.class);
	}
}
