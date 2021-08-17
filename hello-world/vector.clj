(ns vector)

(def prices [30 700 1000])

(println (prices 0))
(println (prices 4))                                        ;IndexOutOfBoundsException

(println (get prices 0))
(println (get prices 4))                                    ;default value nil
(println (get prices 4 0))                                  ;default value 0

(println (conj prices 850))

(println (update prices 0 inc))
