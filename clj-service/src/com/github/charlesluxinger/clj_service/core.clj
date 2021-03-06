(ns com.github.charlesluxinger.clj-service.core
  (:require [io.pedestal.http.route :as route]
            [io.pedestal.http :as http]))
(defn hello-func [request]
  {:status 200 :body (str "Hello World " (get-in request [:query-params :name]))})

(def routes (route/expand-routes
              #{["/hello" :get hello-func :route-name :hello-world]}))

(def service-map {::http/routes routes
                  ::http/port   9999
                  ::http/type   :jetty
                  ::http/join?  false?})

(http/start (http/create-server service-map))