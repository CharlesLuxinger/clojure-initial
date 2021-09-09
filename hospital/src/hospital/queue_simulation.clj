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

(queue-simulation)
