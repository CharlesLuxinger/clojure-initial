(ns hospital.queue-simulation
  (:use [clojure pprint])
  (:require [hospital.model :as h.model]
            [hospital.logic :as h.logic]))

(defn queue-simulation []
  ; root binding
  (def hospital (h.model/new-empty-queue))
  (def hospital (h.logic/come-in hospital :wait "111"))
  (def hospital (h.logic/come-in hospital :wait "222"))
  (def hospital (h.logic/come-in hospital :wait "333"))
  (pprint hospital)

  (def hospital (h.logic/come-in hospital :laboratory1 "444"))
  (def hospital (h.logic/come-in hospital :laboratory3 "555"))
  (pprint hospital)

  (def hospital (h.logic/call hospital :laboratory1))
  (def hospital (h.logic/call hospital :wait))
  (pprint hospital))

;(queue-simulation)

(defn come-in-the-devil [person]
  (def hospital (h.logic/come-in-sleep hospital :wait person))
  (println "after insert:" person))

(defn queue-simulation-in-parallel
  []
  (def hospital (h.model/new-empty-queue))
  (.start (Thread. (fn [] (come-in-the-devil "111"))))
  (.start (Thread. (fn [] (come-in-the-devil "222"))))
  (.start (Thread. (fn [] (come-in-the-devil "333"))))
  (.start (Thread. (fn [] (come-in-the-devil "444"))))
  (.start (Thread. (fn [] (come-in-the-devil "555"))))
  (.start (Thread. (fn [] (come-in-the-devil "666"))))
  (.start (Thread. (fn [] (Thread/sleep 4000)
                     (pprint hospital)))))

(queue-simulation-in-parallel)
