package com.otis.test.ej3;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class FavoritesTest {

    public static void main(String args[]) {
        Favorites favorites = new Favorites();
        favorites.putFavorite(String.class, "Hello World");
        favorites.putFavorite(Integer.class, Integer.valueOf(10));

        System.out.println(favorites.getFavorite(String.class));
        System.out.println(String.valueOf(favorites.getFavorite(Integer.class)));
    }

    public static class Favorites {
        private Map<Class<?>, Object> favorites = new HashMap<>();

        public <T> void putFavorite(Class<T> type, T instance) {
            favorites.put(Objects.requireNonNull(type), instance);
        }

        public <T> T getFavorite(Class<T> type) {
            return type.cast(favorites.get(type));
        }
    }
}