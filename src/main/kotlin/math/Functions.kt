package math

fun <E> max(bags: Collection<E>, comparator: Comparator<E>): E {
    return bags.sortedWith(comparator).first()
}