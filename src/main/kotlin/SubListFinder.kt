/**
 * Keeps track of where the list started ([firstIndex]) and where the current end ([lastIndex]] is. Also what [degree]
 * the number [trackedValue] has.
 *
 */
data class Tracker(val firstIndex: Int, val lastIndex: Int, val degree: Int, val trackedValue: Int)

class SubListFinder {
    companion object {
        /**
         * Given an [input] list of non-negative integers, return the shortest sub-list with the same degree as the original
         * list.
         *
         * @return the shortest sub-list of [input] with the same degree as [input]
         */
        fun from(input: List<Int>): List<Int> {

            if (input.isEmpty()) return emptyList()

            var trackerByInt: MutableMap<Int, Tracker> = mutableMapOf()

            var best = Tracker(0, 0, 1, trackedValue = input[0])

            for ((index, value) in input.withIndex()) {
                val tracker = trackerByInt[value]

                // Either update lastIndex and degree if value is being tracked, or create new Tracker for this value
                val currentTracker =
                    tracker?.copy(lastIndex = index, degree = tracker.degree + 1) ?: Tracker(index, index, 1, value)

                // It's a new best if the degree is the same but the new sub-list is shorter. It's also better if the
                // degree is highger
                if (currentTracker.length() < best.length() && currentTracker.degree == best.degree
                    || currentTracker.degree > best.degree) {
                    best = currentTracker.copy()
                }

                trackerByInt[value] = currentTracker
            }

            return input.subList(best.firstIndex, best.lastIndex + 1)
        }

        private fun Tracker.length(): Int {
            return this.lastIndex - this.firstIndex + 1
        }
    }
}