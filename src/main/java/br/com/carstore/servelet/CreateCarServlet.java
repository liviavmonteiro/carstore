package br.com.carstore.servelet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import br.com.carstore.model.Car;
import br.com.carstore.dao.CarDao;

@WebServlet("/create-car")
public class CreateCarServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String carName = request.getParameter("car-name");

        System.out.println(carName);

        Car car = new Car(carName);

        CarDao carDao = new CarDao();

        carDao.createCar(car);

        request.getRequestDispatcher("index.html").forward(request, response);
    }
}
