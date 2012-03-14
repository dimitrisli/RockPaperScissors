package rock.paper.scissors.base;

/**
 * Although Enum implements Comparable<T>, it sets the compareTo method as final
 * because it assumes the de facto ordering is the natural ordering (the order
 * Enum elements are declared) and therefore it doesn't let us override it.
 * This is a workaround and more tailored compareTo implementation to our
 * purposes.
 * 
 * @author dimitrios.liapis
 * 
 * @param <T>
 * @param <E>
 */
public interface TailoredComparable<T, E> {
	public E tailoredCompareTo(T t);
}