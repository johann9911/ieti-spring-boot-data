package org.ada.school.controller;

import org.ada.school.dto.UserDto;
import org.ada.school.model.User;
import org.ada.school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping( "/user" )
public class UserController
{

    private final UserService userService;

    public UserController( @Autowired UserService userService )
    {
        this.userService = userService;
    }


    @GetMapping
    public ResponseEntity<List<User>> all()
    {
        return ResponseEntity.ok( userService.all() );
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<User> findById( @PathVariable String id )
    {
        return ResponseEntity.ok( userService.findById( id ) );
    }


    @PostMapping
    public ResponseEntity<User> create( @RequestBody UserDto userDto )
    {
        return ResponseEntity.ok( userService.create( new User( userDto ) ) );
    }

    @PutMapping( "/{id}" )
    public ResponseEntity<User> update( @RequestBody UserDto userDto, @PathVariable String id )
    {
        return ResponseEntity.ok( userService.update( userDto, id ) );
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<Boolean> delete( @PathVariable String id )
    {
        return ResponseEntity.ok( userService.deleteById( id ) );
    }

    @GetMapping("/query/like/{queryText}")
    public ResponseEntity<List<User>> findUsersWithNameOrLastNameLike( @PathVariable String queryText )
    {
        return ResponseEntity.ok( userService.findUsersWithNameOrLastNameLike(queryText));
    }

    @GetMapping("/query/date/{date}")
    public ResponseEntity<List<User>> findUsersCreatedAfter( @PathVariable String date) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date startDate = formato.parse(date);
        return ResponseEntity.ok( userService.findUsersCreatedAfter(startDate));
    }


}
