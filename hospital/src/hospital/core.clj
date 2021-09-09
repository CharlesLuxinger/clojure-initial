(ns hospital.core
  (:use [clojure pprint])
  (:require [hospital.model :as h.model]))

(let [new-hospital (h.model/new-empty-queue)]
  (pprint new-hospital))

(pprint h.model/new-empty-queue)
