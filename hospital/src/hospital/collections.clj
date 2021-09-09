(ns hospital.collections
    (:use [clojure pprint]))

(defn vector-test []
      (let [wait [111 222]]
           (println "vector-test")
           (println wait)
           (println (conj wait 333))
           (println (conj wait 444))
           (println (pop wait))))

(vector-test)


;################################

(defn list-test []
      (let [wait '(111 222)]
           (println "list-test")
           (println wait)
           (println (conj wait 333))
           (println (conj wait 444))
           (println (pop wait))))

(list-test)

;################################

(defn set-test []
      (let [wait #{111 222}]
           (println "set-test")
           (println wait)
           (println (conj wait 333))
           (println (conj wait 444))
           ;(println (pop wait)) #Doesnt work in set
           ))

(set-test)

;################################

(defn queue-test []
      (let [wait (conj clojure.lang.PersistentQueue/EMPTY "111" "222")]
           (println "queue-test")
           (println (seq wait)
                    (println (seq (conj wait "333")))
                    ;(println (seq (pop wait))) #Doesnt work in set
                    (println (peek wait))
                    (pprint wait))))

(queue-test)