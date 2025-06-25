package com.core;

import com.core.db.mascotasManager;
import com.core.modules.entityclasses.Departamentos;
import com.core.modules.entityclasses.Mascotas;

@SuppressWarnings("unused")
public class main {
    public static void main(String[] args) {

        mascotasManager mManager = new mascotasManager();
        String mascotaInfo = mManager.findMascota(5).toString();

        System.out.println(mascotaInfo);
    }
}
