(ns problem-004.core
  (:require [clojure.math.numeric-tower :as math]
            [clojure.string :as s])
  (:gen-class))

(defn ispalindrome? [num]
  (let [num-str (str num)
        num-length (count num-str)
        num-slice-depth (int (/ num-length 2))
        str-left (subs num-str 0 num-slice-depth)
        str-right (subs num-str (- num-length num-slice-depth))]
    (= str-left (s/reverse str-right))))

;;(ispalindrome? 1100000011)

(defn nth-digit-palindrome-list [num]
  (let [lower-num (math/expt 10 (dec num))
        upper-num (math/expt 10 num)
        num-range (range lower-num upper-num)
        mult-list (for [i num-range j num-range] (* i j))]
    (filter ispalindrome? mult-list)))

(defn -main
  [& args]
  (println "Started Problem 4 Calculation...")
  (print " : ")
  (println (apply max (nth-digit-palindrome-list 3))))
  
