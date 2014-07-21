(ns gameoflife.core)

(defn neighbours [[x y]]
  (for [dx [-1 0 1]
        dy [-1 0 1]
        :when (not= 0 dx dy)]
    [(+ dx x) (+ dy y)]))

(defn live [n alive?]
  (or (= n 3) (and (= n 2) alive?)))

(defn next-generation [board]
  (set
    (for [[cell n] (frequencies (mapcat neighbours board))
          :when (live n (board cell))]
      cell)))
