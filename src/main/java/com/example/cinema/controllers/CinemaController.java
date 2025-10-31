package com.example.cinema.controllers;

import com.example.cinema.models.*;
import com.example.cinema.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class CinemaController {
  @Autowired
  private EmployeeRepository employeeRepository;
  @Autowired
  private PostRepository postRepository;
  @Autowired
  private CategoryRepository categoryRepository;
  @Autowired
  private CinemaRepository cinemaRepository;
  @Autowired
  private FilmRepository filmRepository;
  @Autowired
  private GenreRepository genreRepository;
  @Autowired
  private HallRepository hallRepository;
  @Autowired
  private PlaceRepository placeRepository;
  @Autowired
  private SessionRepository sessionRepository;
  @Autowired
  private TicketRepository ticketRepository;

  @GetMapping("/employee")
  public String employeeMain(Model model) {
    Iterable<Employee> employee = employeeRepository.findAll();
    model.addAttribute("employee", employee);
    return "/main/employee";
  }

  @GetMapping("/category")
  public String categoryMain(Model model) {
    Iterable<Category> category = categoryRepository.findAll();
    model.addAttribute("category", category);
    return "/main/category";
  }

  @GetMapping("/cinema")
  public String cinemaMain(Model model) {
    Iterable<Cinema> cinema = cinemaRepository.findAll();
    model.addAttribute("cinema", cinema);
    return "/main/cinema";
  }

  @GetMapping("/film")
  public String filmMain(Model model) {
    Iterable<Film> film = filmRepository.findAll();
    model.addAttribute("film", film);
    return "/main/film";
  }

  @GetMapping("/genre")
  public String genreMain(Model model) {
    Iterable<Genre> genre = genreRepository.findAll();
    model.addAttribute("genre", genre);
    return "/main/genre";
  }

  @GetMapping("/hall")
  public String hallMain(Model model) {
    Iterable<Hall> hall = hallRepository.findAll();
    model.addAttribute("hall", hall);
    return "/main/hall";
  }

  @GetMapping("/place")
  public String placeMain(Model model) {
    Iterable<Place> place = placeRepository.findAll();
    model.addAttribute("place", place);
    return "/main/place";
  }

  @GetMapping("/session")
  public String sessionMain(Model model) {
    Iterable<Session> sessions = sessionRepository.findAll();
    model.addAttribute("sessions", sessions);
    return "/main/session";
  }

  @GetMapping("/ticket")
  public String ticketMain(Model model) {
    Iterable<Ticket> ticket = ticketRepository.findAll();
    model.addAttribute("ticket", ticket);
    return "/main/ticket";
  }

  @GetMapping("/post")
  public String postMain(Model model) {
    Iterable<Post> post = postRepository.findAll();
    model.addAttribute("post", post);
    return "/main/post";
  }


  @GetMapping("/post/addPost")
  public String addPost(Post post) {
    return "/add/addPost";
  }

  @PostMapping("/post/addPost")
  public String genreAdd(@Valid Post post, BindingResult bindingResultresult,
                         @RequestParam String name, Model model) {
    if (bindingResultresult.hasErrors())
      return "/add/addPost";
    List<Post> res = postRepository.findByName(name);
    if (res.size() > 0) {
      ObjectError error = new ObjectError("name", "Такое название уже есть!");
      bindingResultresult.addError(error);
      return "/add/addPost";
    } else {
      postRepository.save(post);
      return "redirect:/post";
    }
  }


  @GetMapping("/category/addCategory")
  public String addCategory(Category category) {
    return "/add/addCategory";
  }

  @PostMapping("/category/addCategory")
  public String categoryAdd(@Valid Category category, BindingResult bindingResultresult,
                            @RequestParam String name, Model model) {
    if (bindingResultresult.hasErrors())
      return "/add/addCategory";
    List<Category> res = categoryRepository.findByName(name);
    if (res.size() > 0) {
      ObjectError error = new ObjectError("name", "Такое название уже есть!");
      bindingResultresult.addError(error);
      return "/add/addCategory";
    } else {
      categoryRepository.save(category);
      return "redirect:/category";
    }
  }

  @GetMapping("/genre/addGenre")
  public String addGenre(Genre genre) {
    return "/add/addGenre";
  }

  @PostMapping("/genre/addGenre")
  public String genreAdd(@Valid Genre genre, BindingResult bindingResultresult,
                         @RequestParam String name, Model model) {
    if (bindingResultresult.hasErrors())
      return "/add/addGenre";
    List<Genre> res = genreRepository.findByName(name);
    if (res.size() > 0) {
      ObjectError error = new ObjectError("name", "Такое название уже есть!");
      bindingResultresult.addError(error);
      return "/add/addGenre";
    } else {
      genreRepository.save(genre);
      return "redirect:/genre";
    }
  }

  @GetMapping("/place/addPlace")
  public String addPlace(Place place) {
    return "/add/addPlace";
  }

  @PostMapping("/place/addPlace")
  public String placeAdd(@Valid Place place, BindingResult bindingResultresult,
                         Model model) {
    if (bindingResultresult.hasErrors())
      return "/add/addPlace";

    else
      placeRepository.save(place);
    return "redirect:/place";

  }

  @GetMapping("/cinema/addCinema")
  public String addCinema(Cinema cinema) {
    return "/add/addCinema";
  }

  @PostMapping("/cinema/addCinema")
  public String cinemaAdd(@Valid Cinema cinema, BindingResult bindingResultresult,
                          @RequestParam String name, Model model) {
    if (bindingResultresult.hasErrors())
      return "/add/addCinema";
    List<Cinema> res = cinemaRepository.findByName(name);
    if (res.size() > 0) {
      ObjectError error = new ObjectError("name", "Такое название уже есть!");
      bindingResultresult.addError(error);
      return "/add/addCinema";
    } else {
      cinemaRepository.save(cinema);
      return "redirect:/cinema";
    }
  }


  @GetMapping("/post/{id}/edit")
  public String postEdit(@PathVariable(value = "id") long id, Post post, Model model) {

    if (!postRepository.existsById(id)) {
      return "redirect:/post";
    }
    Optional<Post> post1 = postRepository.findById(id);
    ArrayList<Post> res = new ArrayList<>();
    post1.ifPresent(res::add);
    model.addAttribute("postEdit", res);
    return "/edit/postEdit";
  }

  @PostMapping("/post/{id}/edit")
  public String postPostUpdate(@Valid Post post, BindingResult bindingResultresult,
                               @PathVariable(value = "id") long id, @RequestParam String name,
                               Model model) {
    List<Post> res = postRepository.findByName(name);

    if (bindingResultresult.hasErrors()) {
      res = new ArrayList<>();
      res.add(post);
      model.addAttribute("postEdit", res);
      return "/edit/postEdit";
    }

    if (res.size() > 0) {
      ObjectError error = new ObjectError("name", "Такое название уже есть!");
      bindingResultresult.addError(error);
      res = new ArrayList<>();
      res.add(post);
      model.addAttribute("postEdit", res);
      return "/edit/postEdit";
    } else {
      postRepository.save(post);
      return "redirect:/post";
    }
  }

  @GetMapping("/post/{id}/remove")
  public String postPostDelete(@PathVariable(value = "id") long id, Model model) {
    Post post = postRepository.findById(id).orElseThrow();
    postRepository.delete(post);
    return "redirect:/post";
  }


  @GetMapping("/category/{id}/edit")
  public String categoryEdit(@PathVariable(value = "id") long id, Category category, Model model) {

    if (!categoryRepository.existsById(id)) {
      return "redirect:/category";
    }
    Optional<Category> category1 = categoryRepository.findById(id);
    ArrayList<Category> res = new ArrayList<>();
    category1.ifPresent(res::add);
    model.addAttribute("categoryEdit", res);
    return "/edit/categoryEdit";
  }

  @PostMapping("/category/{id}/edit")
  public String categoryPostUpdate(@Valid Category category, BindingResult bindingResultresult,
                                   @PathVariable(value = "id") long id, @RequestParam String name,
                                   Model model) {
    List<Category> res = categoryRepository.findByName(name);

    if (bindingResultresult.hasErrors()) {
      res = new ArrayList<>();
      res.add(category);
      model.addAttribute("categoryEdit", res);
      return "/edit/categoryEdit";
    }

    if (res.size() > 0) {
      ObjectError error = new ObjectError("name", "Такое название уже есть!");
      bindingResultresult.addError(error);
      res = new ArrayList<>();
      res.add(category);
      model.addAttribute("categoryEdit", res);
      return "/edit/categoryEdit";
    } else {
      categoryRepository.save(category);
      return "redirect:/category";
    }
  }

  @GetMapping("/category/{id}/remove")
  public String categoryPostDelete(@PathVariable(value = "id") long id, Model model) {
    Category category = categoryRepository.findById(id).orElseThrow();
    categoryRepository.delete(category);
    return "redirect:/category";
  }


  @GetMapping("/genre/{id}/edit")
  public String genreEdit(@PathVariable(value = "id") long id, Genre genre, Model model) {

    if (!genreRepository.existsById(id)) {
      return "redirect:/genre";
    }
    Optional<Genre> genre1 = genreRepository.findById(id);
    ArrayList<Genre> res = new ArrayList<>();
    genre1.ifPresent(res::add);
    model.addAttribute("genreEdit", res);
    return "/edit/genreEdit";
  }

  @PostMapping("/genre/{id}/edit")
  public String genrePostUpdate(@Valid Genre genre, BindingResult bindingResultresult,
                                @PathVariable(value = "id") long id, @RequestParam String name,
                                Model model) {
    List<Genre> res = genreRepository.findByName(name);

    if (bindingResultresult.hasErrors()) {
      res = new ArrayList<>();
      res.add(genre);
      model.addAttribute("genreEdit", res);
      return "/edit/genreEdit";
    }

    if (res.size() > 0) {
      ObjectError error = new ObjectError("name", "Такое название уже есть!");
      bindingResultresult.addError(error);
      res = new ArrayList<>();
      res.add(genre);
      model.addAttribute("genreEdit", res);
      return "/edit/genreEdit";
    } else {
      genreRepository.save(genre);
      return "redirect:/genre";
    }
  }

  @GetMapping("/genre/{id}/remove")
  public String genrePostDelete(@PathVariable(value = "id") long id, Model model) {
    Genre genre = genreRepository.findById(id).orElseThrow();
    genreRepository.delete(genre);
    return "redirect:/genre";
  }


  @GetMapping("/cinema/{id}/edit")
  public String cinemaEdit(@PathVariable(value = "id") long id, Cinema cinema, Model model) {

    if (!cinemaRepository.existsById(id)) {
      return "redirect:/cinema";
    }
    Optional<Cinema> cinema1 = cinemaRepository.findById(id);
    ArrayList<Cinema> res = new ArrayList<>();
    cinema1.ifPresent(res::add);
    model.addAttribute("cinemaEdit", res);
    return "/edit/cinemaEdit";
  }

  @PostMapping("/cinema/{id}/edit")
  public String cinemaPostUpdate(@Valid Cinema cinema, BindingResult bindingResultresult,
                                 @PathVariable(value = "id") long id, @RequestParam String name,
                                 Model model) {
    List<Cinema> res = cinemaRepository.findByName(name);

    if (bindingResultresult.hasErrors()) {
      res = new ArrayList<>();
      res.add(cinema);
      model.addAttribute("cinemaEdit", res);
      return "/edit/cinemaEdit";
    }

    if (res.size() > 0) {
      ObjectError error = new ObjectError("name", "Такое название уже есть!");
      bindingResultresult.addError(error);
      res = new ArrayList<>();
      res.add(cinema);
      model.addAttribute("cinemaEdit", res);
      return "/edit/cinemaEdit";
    } else {
      cinemaRepository.save(cinema);
      return "redirect:/cinema";
    }
  }

  @GetMapping("/cinema/{id}/remove")
  public String cinemaPostDelete(@PathVariable(value = "id") long id, Model model) {
    Cinema cinema = cinemaRepository.findById(id).orElseThrow();
    cinemaRepository.delete(cinema);
    return "redirect:/cinema";
  }


  @GetMapping("/place/{id}/edit")
  public String placeEdit(@PathVariable(value = "id") long id, Place place, Model model) {

    if (!placeRepository.existsById(id)) {
      return "redirect:/place";
    }
    Optional<Place> place1 = placeRepository.findById(id);
    ArrayList<Place> res = new ArrayList<>();
    place1.ifPresent(res::add);
    model.addAttribute("placeEdit", res);
    return "/edit/placeEdit";
  }

  @PostMapping("/place/{id}/edit")
  public String placePostUpdate(@Valid Place place, BindingResult bindingResultresult,
                                @PathVariable(value = "id") long id, @RequestParam Integer row,
                                Model model) {
    List<Place> res = placeRepository.findByRow(row);

    if (bindingResultresult.hasErrors()) {
      res = new ArrayList<>();
      res.add(place);
      model.addAttribute("placeEdit", res);
      return "/edit/placeEdit";
    }

    if (res.size() > 0) {
      ObjectError error = new ObjectError("name", "Такое название уже есть!");
      bindingResultresult.addError(error);
      res = new ArrayList<>();
      res.add(place);
      model.addAttribute("placeEdit", res);
      return "/edit/placeEdit";
    } else {
      placeRepository.save(place);
      return "redirect:/place";
    }
  }

  @GetMapping("/place/{id}/remove")
  public String placePostDelete(@PathVariable(value = "id") long id, Model model) {
    Place place = placeRepository.findById(id).orElseThrow();
    placeRepository.delete(place);
    return "redirect:/place";
  }


  @GetMapping("/employee/{id}/remove")
  public String employeePostDelete(@PathVariable(value = "id") long id, Model model) {
    Employee employee = employeeRepository.findById(id).orElseThrow();
    employeeRepository.delete(employee);
    return "redirect:/employee";
  }

  @GetMapping("/employee/addEmployee")
  public String employeeAdd(Employee employee, Model model) {
    Iterable<Post> post = postRepository.findAll();
    model.addAttribute("post", post);
    return "/add/addEmployee";
  }

  @PostMapping("/employee/addEmployee")
  public String employeeAdd(@Valid Employee employee, BindingResult bindingResult,
                            @RequestParam String firstname,
                            @RequestParam String lastname,
                            @RequestParam String thirdname,
                            @RequestParam String email,
                            @RequestParam String phone,
                            @RequestParam String name,
                            Model model) {
    if (bindingResult.hasErrors())
      return "/add/addEmployee";

    List<Employee> res = employeeRepository.findByEmail(email);
    Post post1 = postRepository.findPostByName(name);
    if (res.size() > 0) {
      ObjectError error = new ObjectError("email", "Такое название уже есть!");
      bindingResult.addError(error);
      return "/add/addEmployee";
    } else {
      Employee employee1 = new Employee(firstname, lastname, thirdname, email, phone, post1);
      employeeRepository.save(employee1);
      return "redirect:/employee";
    }
  }


  @GetMapping("/genre/genreFilter")
  public String genreFilter(Model model) {
    return "/filter/genreFilter";
  }

  @PostMapping("/genre/genreFilter")
  public String genreResult(@RequestParam String name, Model model) {
    List<Genre> result = genreRepository.findByName(name);
    model.addAttribute("result", result);

    List<Genre> result_str = genreRepository.findByNameContaining(name);
    model.addAttribute("result_str", result_str);
    return "/filter/genreFilter";
  }


  @GetMapping("/cinema/cinemaFilter")
  public String cinemaFilter(Model model) {
    return "/filter/cinemaFilter";
  }

  @PostMapping("/cinema/cinemaFilter")
  public String cinemaResult(@RequestParam String name, Model model) {
    List<Cinema> result = cinemaRepository.findByName(name);
    model.addAttribute("result", result);

    List<Cinema> result_str = cinemaRepository.findByNameContaining(name);
    model.addAttribute("result_str", result_str);
    return "/filter/cinemaFilter";
  }


  @GetMapping("/post/postFilter")
  public String postFilter(Model model) {
    return "/filter/postFilter";
  }

  @PostMapping("/post/postFilter")
  public String postResult(@RequestParam String name, Model model) {
    List<Post> result = postRepository.findByName(name);
    model.addAttribute("result", result);

    List<Post> result_str = postRepository.findByNameContaining(name);
    model.addAttribute("result_str", result_str);
    return "/filter/postFilter";
  }


  @GetMapping("/category/categoryFilter")
  public String categoryFilter(Model model) {
    return "/filter/categoryFilter";
  }

  @PostMapping("/category/categoryFilter")
  public String categoryResult(@RequestParam String name, Model model) {
    List<Category> result = categoryRepository.findByName(name);
    model.addAttribute("result", result);

    List<Category> result_str = categoryRepository.findByNameContaining(name);
    model.addAttribute("result_str", result_str);
    return "/filter/categoryFilter";
  }


  @GetMapping("/employee/employeeFilter")
  public String employeeFilter(Model model) {
    return "/filter/employeeFilter";
  }

  @PostMapping("/employee/employeeFilter")
  public String employeeResult(@RequestParam String name, Model model) {
    List<Employee> result = employeeRepository.findByLastname(name);
    model.addAttribute("result", result);

    List<Employee> result_str = employeeRepository.findByLastnameContaining(name);
    model.addAttribute("result_str", result_str);
    return "/filter/employeeFilter";
  }


  @GetMapping("/employee/{id}")
  public String employeeDetails(@PathVariable(value = "id") long id, Model model) {
    Optional<Employee> employee = employeeRepository.findById(id);
    ArrayList<Employee> res = new ArrayList<>();
    employee.ifPresent(res::add);
    model.addAttribute("employee", res);
    return "/details/employeeDetails";
  }


  @GetMapping("/hall/hallFilter")
  public String hallFilter(Model model) {
    return "/filter/hallFilter";
  }

  @PostMapping("/hall/hallFilter")
  public String hallResult(@RequestParam String name, Model model) {
    List<Hall> result = hallRepository.findByName(name);
    model.addAttribute("result", result);

    List<Hall> result_str = hallRepository.findByNameContaining(name);
    model.addAttribute("result_str", result_str);
    return "/filter/hallFilter";
  }

  @GetMapping("/hall/{id}")
  public String hallDetails(@PathVariable(value = "id") long id, Model model) {
    Optional<Hall> hall = hallRepository.findById(id);
    ArrayList<Hall> res = new ArrayList<>();
    hall.ifPresent(res::add);
    model.addAttribute("hall", res);
    return "/details/hallDetails";
  }

  @GetMapping("/hall/{id}/remove")
  public String hallPostDelete(@PathVariable(value = "id") long id, Model model) {
    Hall hall = hallRepository.findById(id).orElseThrow();
    hallRepository.delete(hall);
    return "redirect:/hall";
  }


  @GetMapping("/session/sessionFilter")
  public String sessionFilter(Model model) {
    return "/filter/sessionFilter";
  }

  @PostMapping("/session/sessionFilter")
  public String sessionResult(@RequestParam String time, Model model) {
    List<Session> result = sessionRepository.findByTime(time);
    model.addAttribute("result", result);

    List<Session> result_str = sessionRepository.findByTimeContaining(time);
    model.addAttribute("result_str", result_str);
    return "/filter/sessionFilter";
  }

  @GetMapping("/session/{id}/remove")
  public String sessionsPostDelete(@PathVariable(value = "id") long id, Model model) {
    Session sessions = sessionRepository.findById(id).orElseThrow();
    sessionRepository.delete(sessions);
    return "redirect:/session";
  }

  @GetMapping("/session/{id}")
  public String SessionDetails(@PathVariable(value = "id") long id, Model model) {
    Optional<Session> sessions = sessionRepository.findById(id);
    ArrayList<Session> res = new ArrayList<>();
    sessions.ifPresent(res::add);
    model.addAttribute("sessions", res);
    return "/details/sessionDetails";
  }


  @GetMapping("/film/filmFilter")
  public String filmFilter(Model model) {
    return "/filter/filmFilter";
  }

  @PostMapping("/film/filmFilter")
  public String filmResult(@RequestParam String name, Model model) {
    List<Film> result = filmRepository.findByName(name);
    model.addAttribute("result", result);

    List<Film> result_str = filmRepository.findByNameContaining(name);
    model.addAttribute("result_str", result_str);
    return "/filter/filmFilter";
  }

  @GetMapping("/film/{id}/remove")
  public String filmPostDelete(@PathVariable(value = "id") long id, Model model) {
    Film film = filmRepository.findById(id).orElseThrow();
    filmRepository.delete(film);
    return "redirect:/film";
  }


  @GetMapping("/film/{id}")
  public String filmDetails(@PathVariable(value = "id") long id, Model model) {
    Optional<Film> film = filmRepository.findById(id);
    ArrayList<Film> res = new ArrayList<>();
    film.ifPresent(res::add);
    model.addAttribute("film", res);
    return "/details/filmDetails";
  }


  @GetMapping("/ticket/ticketFilter")
  public String ticketFilter(Model model) {
    return "/filter/ticketFilter";
  }

  @PostMapping("/ticket/ticketFilter")
  public String ticketResult(@RequestParam String name, Model model) {
    List<Ticket> result = ticketRepository.findByCinemaName(name);
    model.addAttribute("result", result);

    List<Ticket> result_str = ticketRepository.findByCinemaNameContaining(name);
    model.addAttribute("result_str", result_str);
    return "/filter/ticketFilter";
  }

  @GetMapping("/ticket/{id}/remove")
  public String ticketPostDelete(@PathVariable(value = "id") long id, Model model) {
    Ticket ticket = ticketRepository.findById(id).orElseThrow();
    ticketRepository.delete(ticket);
    return "redirect:/ticket";
  }

  @GetMapping("/ticket/{id}")
  public String ticketDetails(@PathVariable(value = "id") long id, Model model) {
    Optional<Ticket> ticket = ticketRepository.findById(id);
    ArrayList<Ticket> res = new ArrayList<>();
    ticket.ifPresent(res::add);
    model.addAttribute("ticket", res);
    return "/details/ticketDetails";
  }


  @GetMapping("/film/addFilm")
  public String filmAdd(Film film, Model model) {
    Iterable<Genre> genres = genreRepository.findAll();
    model.addAttribute("genre", genres);
    return "/add/addFilm";
  }

  @PostMapping("/film/addFilm")
  public String filmAdd(@Valid Film film, BindingResult bindingResult,
                        @RequestParam String name,
                        @RequestParam String genrename,
                        @RequestParam String time,
                        @RequestParam String description,
                        Model model) {
    if (bindingResult.hasErrors())
      return "/add/addFilm";

    List<Film> res = filmRepository.findByName(name);
    Genre genre1 = genreRepository.findFilmByName(genrename);
    if (res.size() > 0) {
      ObjectError error = new ObjectError("name", "Такое название уже есть!");
      bindingResult.addError(error);
      return "/add/addFilm";
    } else {
      Film film1 = new Film(name, time, description, genre1);
      filmRepository.save(film1);
      return "redirect:/film";
    }
  }


  @GetMapping("/session/addSession")
  public String sessionAdd(Session session, Model model) {
    Iterable<Film> films = filmRepository.findAll();
    model.addAttribute("film", films);

    Iterable<Hall> halls = hallRepository.findAll();
    model.addAttribute("hall", halls);
    return "/add/addSession";
  }

  @PostMapping("/session/addSession")
  public String sessionAdd(@Valid Session session, BindingResult bindingResult,
                           @RequestParam String time,
                           @RequestParam String date,
                           @RequestParam String filmname,
                           @RequestParam String hallname,
                           Model model) {
    if (bindingResult.hasErrors())
      return "/add/addSession";

    List<Session> res = sessionRepository.findByTime(time);
    Film film1 = filmRepository.findFilmByName(filmname);
    Hall hall2 = hallRepository.findHallByName(hallname);


    Session session1 = new Session(time, date, hall2, film1);
    sessionRepository.save(session1);
    return "redirect:/session";
  }


  @GetMapping("/ticket/addTicket")
  public String ticketAdd(Ticket ticket, Model model) {
    Iterable<Cinema> cinemas = cinemaRepository.findAll();
    model.addAttribute("cinema", cinemas);

    Iterable<Hall> halls = hallRepository.findAll();
    model.addAttribute("hall", halls);

    Iterable<Place> places = placeRepository.findAll();
    model.addAttribute("place", places);

    Iterable<Employee> employees = employeeRepository.findAll();
    model.addAttribute("employee", employees);
    return "/add/addTicket";
  }

  @PostMapping("/ticket/addTicket")
  public String ticketAdd(@Valid Ticket ticket,
                          @RequestParam String cinemaname,
                          @RequestParam String hallname,
                          @RequestParam Integer placerow,
                          @RequestParam String employeelastname,
                          Model model) {

    Cinema cinema1 = cinemaRepository.findCinemaByName(cinemaname);
    Hall hall1 = hallRepository.findHallByName(hallname);
    Place place1 = placeRepository.findPlaceByRow(placerow);
    Employee employee1 = employeeRepository.findEmployeeByLastname(employeelastname);


    Ticket ticket1 = new Ticket(cinema1, hall1, place1, employee1);
    ticketRepository.save(ticket1);
    return "redirect:/ticket";
  }


  @GetMapping("/hall/addHall")
  public String hallAdd(Hall hall, Model model) {
    Iterable<Category> categories = categoryRepository.findAll();
    model.addAttribute("category", categories);


    return "/add/addHall";
  }

  @PostMapping("/hall/addHall")
  public String hallAdd(@Valid Hall hall, BindingResult bindingResult,
                        @RequestParam String name,
                        @RequestParam Integer capacity,
                        @RequestParam String categoryname,
                        Model model) {
    if (bindingResult.hasErrors())
      return "/add/addHall";

    List<Hall> res = hallRepository.findByName(name);
    Category category1 = categoryRepository.findCategoryByName(categoryname);


    Hall hall1 = new Hall(name, capacity, category1);
    hallRepository.save(hall1);
    return "redirect:/hall";
  }
}
