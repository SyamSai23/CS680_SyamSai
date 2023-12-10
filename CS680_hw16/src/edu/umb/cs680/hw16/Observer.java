package edu.umb.cs680.hw16;

import java.util.function.Consumer;

public interface Observer<T>   {
	public void update(Observable<T> sender, T event);
}

