(ns reduce)

(def prices [30 700 1000])

(println (reduce + prices))
(println (reduce + 1 prices))                               ;Second Array Element
