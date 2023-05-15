package org.acme;

import io.smallrye.mutiny.Uni;
import org.hibernate.reactive.mutiny.Mutiny;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.Tuple;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ClientRepository {

    @Inject
    Mutiny.SessionFactory sf;

    public Uni<List<Object>> findAll() {
        // FIXME: consulta com coluna binária 'id' lançando exceção java.lang.ClassCastException: Invalid String value type class io.vertx.core.buffer.impl.BufferImpl
        return sf.withSession(session -> session
                .createNativeQuery("select id, first_name from client", Tuple.class)
                .getResultList()
                .map(this::transformTuple));
    }

    private List<Object> transformTuple(List<Tuple> tuples) {
        List<Object> list = new ArrayList<>();

        for (Tuple tuple : tuples) {
            for (int i = 0; i < tuple.getElements().size(); i++) {
                list.add(tuple.get(i));
            }
        }

        return list;
    }

}
