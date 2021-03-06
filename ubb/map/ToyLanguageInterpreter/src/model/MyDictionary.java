package model;

import exception.KeyNotExistException;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cosmin on 10/24/16.
 */
public class MyDictionary <K, V> implements MyIDictionary<K, V>  {
    private HashMap<K, V> _map;

    public MyDictionary(HashMap<K, V> _map) {
        this._map = _map;
    }

    @Override
    public V put(K key, V value) {
        return this._map.put(key, value);
    }

    @Override
    public V get(K key) {
        return this._map.get(key);
    }

    @Override
    public Collection<V> values() {
        return this._map.values();
    }

    @Override
    public Collection<K> keys() {
        return this._map.keySet();
    }

    @Override
    public V remove(K fd) {
        return this._map.remove(fd);
    }

    @Override
    public MyIDictionary<K, V> clone() {
        MyIDictionary<K, V> dict = new MyDictionary<>(new HashMap<K, V>());
        for(K key : _map.keySet())
            dict.put(key, _map.get(key));
        return dict;
    }

    @Override
    public Map<K, V> toMap() {
        return this._map;
    }

    @Override
    public String toString() {
        String ret = "";
        boolean ok = false;
        for(HashMap.Entry<K, V> entry : this._map.entrySet()) {
            if(ok)
                ret = ret + "\n";
            ret += entry.getKey().toString() + " -> " + entry.getValue().toString();
            ok = true;
        }
        return ret;
    }
}
