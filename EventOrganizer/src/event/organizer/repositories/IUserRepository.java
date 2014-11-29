package event.organizer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import event.organizer.domain.User;

public interface IUserRepository extends JpaRepository<User, Long>{

}
