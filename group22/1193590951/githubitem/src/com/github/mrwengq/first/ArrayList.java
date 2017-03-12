package com.github.mrwengq.first;

public class ArrayList implements List {

	private int size = 0;
	private Object elementData[] = new Object[5];
	
	public void add(Object o) {
		if (size >= elementData.length)
			elementData = copyAddArray(elementData);
		elementData[size] = o;
		size++;
	}

	public void add(int index, Object o) {
		if (index > size - 1 || index < 0) {
			throw new ArrayIndexOutOfBoundsException();
		} else {
			elementData = addUpdateArray(elementData, index);
			elementData[index] = o;
			size++;
			return;
		}
	}

	public Object get(int index) {
		if (index > size - 1 || index < 0)
			throw new ArrayIndexOutOfBoundsException();
		else
			return elementData[index];
	}

	public Object remove(int index) {
		if (index > size - 1 || index < 0)
			throw new ArrayIndexOutOfBoundsException();
		if (index == size - 1) {
			elementData[index] = null;
			size--;
			return null;
		} else {
			delUpdateArray(elementData, index);
			size--;
			return null;
		}
	}

	public int size() {
		return size;
	}

	public Iterator iterator() {
		return new Iterator() {

			int index=-1;

			public boolean hasNext() {
				index++;
				if(index<size){
					
					Object ob = elementData[index];
					return true;
				}
				return false;
			}

			public Object next() {
				return elementData[index];
			}

		};
	}

	private Object[] copyAddArray(Object elementData[]) {
		Object ob[] = new Object[elementData.length+(elementData.length * 3) / 4];
		System.arraycopy(((Object) (elementData)), 0, ((Object) (ob)), 0,
				elementData.length);
		return ob;
	}

	private Object[] addUpdateArray(Object elementData[], int index) {
		Object temp = null;
		for (int i = 0; i < size; i++)
			if (i > index) {
				temp = elementData[index];
				elementData[index] = elementData[i];
				elementData[i] = temp;
				if (i == size - 1) {
					if (size > elementData.length)
						elementData = copyAddArray(elementData);
					elementData[size] = elementData[index];
				}
			}

		return elementData;
	}

	private void delUpdateArray(Object elementData[], int index) {
		for (int i = 0; i < size; i++){
			
			if (i > index && i < size ){
				elementData[i - 1] = elementData[i];				
				if (i == size - 1){
					elementData[i] = null;
				}
			}

		}
	}

}
