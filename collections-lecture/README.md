# Java Collections Cheat Sheet

## List Interface (Ordered Collection)
- Implements ordered a collection of elements.
- Allows duplicate elements.
- Common implementations: ArrayList, LinkedList, Vector.

### Common Operations
- `add(element)`: Adds an element to the end.
- `add(index, element)`: Adds an element at a specific index.
- `get(index)`: Retrieves the element at a specific index.
- `set(index, element)`: Replaces the element at a specific index.
- `remove(index)`: Removes the element at a specific index.
- `size()`: Returns the number of elements.

## Set Interface (Unordered Collection)
- Implements an unordered collection of unique elements.
- Does not allow duplicate elements.
- Common implementations: HashSet, LinkedHashSet, TreeSet.

### Common Operations
- `add(element)`: Adds an element.
- `remove(element)`: Removes an element.
- `contains(element)`: Checks if an element exists.
- `size()`: Returns the number of elements.

## Map Interface (Key-Value Pairs)
- Implements key-value pairs.
- Keys are unique, values may be duplicate.
- Common implementations: HashMap, LinkedHashMap, TreeMap.

### Common Operations
- `put(key, value)`: Adds a key-value pair.
- `get(key)`: Retrieves the value associated with a key.
- `remove(key)`: Removes the key-value pair.
- `containsKey(key)`: Checks if a key exists.
- `keySet()`: Returns a set of keys.
- `values()`: Returns a collection of values.

## Common Methods (Collections Class)
- `Collections.sort(list)`: Sorts a list.
- `Collections.reverse(list)`: Reverses the order of elements in a list.
- `Collections.shuffle(list)`: Shuffles the elements in a list.
- `Collections.max(collection)`: Returns the maximum element.
- `Collections.min(collection)`: Returns the minimum element.

## Sorting and Searching
- Elements must implement Comparable for natural ordering.
- Use Comparator for custom ordering.
- `Collections.sort(list)`, `Collections.sort(list, comparator)` for sorting.
- `Collections.binarySearch(list, key)`: Searches for an element.

## Iteration
- Enhanced for-loop: `for (Type element : collection) { ... }`.
- Iterator: `Iterator<Type> iterator = collection.iterator();`.

## Utility Classes
- `Arrays`: Provides utility methods for arrays.
- `Collections`: Provides utility methods for collections.