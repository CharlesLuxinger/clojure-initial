(ns ecommerce.db
  (:use clojure.pprint)
  (:require [datomic.api :as d]))

(def db-uri "datomic:dev://localhost:4334/ecommerce")

(defn open-connection []
  (d/create-database db-uri)
  (d/connect db-uri))

(defn delete-db []
  (d/delete-database db-uri))

(def schema [{:db/ident       :product/name
              :db/valueType   :db.type/string
              :db/cardinality :db.cardinality/one
              :db/doc         "The name of a product."}
             {:db/ident       :product/slug
              :db/valueType   :db.type/string
              :db/cardinality :db.cardinality/one
              :db/doc         "The path to access through HTTP."}
             {:db/ident       :product/price
              :db/valueType   :db.type/bigdec
              :db/cardinality :db.cardinality/one
              :db/doc         "The price of a product with monetary precision."}])

(defn create-schema [conn]
  (d/transact conn schema))

(defn find-all-products [db]
  (d/q '[:find (pull ?entity [:product/name :product/slug :product/price])
         :where [?entity :product/name]] db))

(defn find-all-products-all-fields [db]
  (d/q '[:find (pull ?entity [*])
         :where [?entity :product/name]] db))

(defn find-all [db]
  (d/q '[:find ?name-bind ?price-bind
         :keys product/name, product/price
         :where [?entity :product/price ?price-bind]
         [?entity :product/name ?name-bind]]
       db))

(defn find-by-slug [db slug]
  (d/q '[:find ?entity
         :in $ ?slug-bind  ;$ in db parameter
         :where [?entity :product/slug ?slug-bind]]
       db slug))

(defn find-all-slug [db]
  (d/q '[:find ?slug
         :where [_ :product/slug ?slug]] db))

(defn find-by-price [db price]
  (d/q '[:find ?name-bind ?price-bind
         :in $ ?price-bind  ;$ in db parameter
         :where [?entity :product/price ?price-bind]
                [?entity :product/name ?name-bind]]
       db price))