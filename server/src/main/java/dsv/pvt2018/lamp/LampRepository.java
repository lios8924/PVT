package dsv.pvt2018.lamp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LampRepository extends JpaRepository<Lamp, Integer> {

	List<Lamp> findByMapId(Integer mapId);

}
