package dsv.pvt2018.lamp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LampRepository extends JpaRepository<Lamp, Integer> {
//	Page<Lamp> findByMapId(Integer mapId, Pageable pageable);
	List<Lamp> findByMapId(Integer mapId);
}
