package com.juint.mockit.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;

class ListMockTest {
	
	@InjectMocks
	List mock= mock(List.class);

	@Test
	void size_basic() {
		List mock1 =mock(List.class);
		when(mock1.size()).thenReturn(5);
		assertEquals(5, mock1.size());
	}
	@Test
	void differentValies() {
		when(mock.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, mock.size());
		assertEquals(10,mock.size());
	}
	@Test
	void returnParameters() {
		when(mock.get(0)).thenReturn("MockitOEx");
		assertEquals("MockitOEx", mock.get(0));
		assertEquals(null, mock.get(1));
	}
	
	@Test
	void returnGenericParameters() {
		when(mock.get(anyInt())).thenReturn("AnyParam");
		assertEquals("AnyParam", mock.get(0));
	}
	
	@Test
	void verification_Basic() {
		String value1 = (String) mock.get(0);
		String value2 = (String) mock.get(1);
		verify(mock).get(0);
		verify(mock, atLeastOnce()).get(1);
		verify(mock, times(2)).get(anyInt());
		verify(mock, atMost(3)).get(1);
	}
	
	@Test
	void argumentCapture() {
		mock.add("StringArg");
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock).add(captor.capture());
		assertEquals("StringArg", captor.getValue());
	}
	@Test
	void multiArgumentCapture() {
		List<String> mock1 = mock(List.class);
		mock1.add("StringArg1");
		mock1.add("StringArg2");
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		
		verify(mock1, times(2)).add(captor.capture());
		List<String> allValues=captor.getAllValues();
		assertEquals("StringArg1", allValues.get(0));
		assertEquals("StringArg2", allValues.get(1));
	}
	
	@Test
	void arrayListMock() {
		ArrayList arrayListMock= mock(ArrayList.class);
		arrayListMock.add("Test1");
		arrayListMock.add("Test2");
		when(arrayListMock.size()).thenReturn(5);
		assertEquals(5, arrayListMock.size());
	}
	
	@Test
	void spying() {
		ArrayList arrayList = spy(ArrayList.class);
		arrayList.add("Test0");
		arrayList.add("Test1");
		arrayList.add("Test2");
		when(arrayList.size()).thenReturn(5);
		assertEquals(5, arrayList.size());
	}
}
