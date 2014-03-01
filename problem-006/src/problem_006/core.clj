(ns problem-006.core
  (:require [clojure.math.numeric-tower :as math])
  (:gen-class))

(defn sum-of-squares
  ([end] (sum-of-squares 1 end))
  ([start end] (reduce + (map #(* % %) (range start (inc end))))))

(sum-of-squares 10)

(defn square-of-sum
  ([end] (square-of-sum 1 end))
  ([start end] (let [sum (reduce + (range start (inc end)))]
                 (* sum sum))))

(square-of-sum 10)

(- (square-of-sum 10) (sum-of-squares 10))

(defn soln []
  (let [sum-squares (sum-of-squares 100)
        square-sums (square-of-sum 100)]
    (- square-sums sum-squares)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (soln)))
