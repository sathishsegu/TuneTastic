	package com.ssktechhub.tunetastic.serviceimpl;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	
	import com.ssktechhub.tunetastic.entity.User;
	import com.ssktechhub.tunetastic.repository.UserRepository;
	import com.ssktechhub.tunetastic.service.UserService;
	
	@Service
	public class UserServiceImpl implements UserService{
	
		@Autowired
		UserRepository userRepository;
		
		@Override
		public String addUser(User user) {
	        if (userExists(user.getEmail(), user.getUsername())) {
	            return "userexists";
	        }
	        userRepository.save(user);
	        return "login";
	    }
	
		@Override
		public boolean validateUser(String email, String password) {
			User user = userRepository.findByEmail(email);
			String dbpwd = user.getPassword();
			if(password.equals(dbpwd)) {
				return true;
			}else {
				return false;
			}
		}
	
		@Override
		public String getRole(String email) {
			User user = userRepository.findByEmail(email);
			return 	user.getRole();
		}
	
		@Override
	    public boolean userExists(String email, String username) {
	        return userRepository.findByEmail(email) != null || userRepository.findByUsername(username) != null;
	    }

		@Override
		public User getUser(String email) {
			return userRepository.findByEmail(email);
		}

		@Override
		public void updateUser(User user) {
			userRepository.save(user);
		}
	}
