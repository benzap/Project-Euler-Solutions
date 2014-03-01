(ns problem-007.core
  (:require [clojure.math.numeric-tower :as math])
  (:gen-class))

(defn isprime? [num]
  (cond
   (< num 2) false
   (= num 2) true
   (= num 3) true
   (zero? (mod num 2)) false
   (zero? (mod num 3)) false
   (let [max-divisor (int (math/ceil (math/sqrt num)))
         num-seq (range 5 max-divisor 6)
         num-mod (filter #(or (zero? (mod num %))
                              (zero? (mod num (+ 2 %)))) num-seq)]
     (empty? num-mod)) true
     :else false))

(defn soln []
  (last (take 10001 (filter isprime? (range)))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (soln)))
