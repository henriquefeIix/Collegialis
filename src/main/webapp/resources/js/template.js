(function () {
  $(document).ready(function () {
    $(".accordion").each(function (index, element) {
      $(element).bind("click", function () {
        let it = this;
        $(it).next().toggleClass("show");
        $(".accordion").each(function (index, element) {
          if (!$(it).is($(element)) && $(element).next().hasClass("show")) {
            $(element).next().removeClass("show");
          }
        });
      });
    });

    $(".collapse-btn").each(function (index, element) {
      $(element).bind("click", function () {
        $(this).next().toggleClass("show");
      });
    });
  });

  $("#calendario").calendar({
    type: "date",
    text: {
      days: ["D", "S", "T", "Q", "Q", "S", "S"],
      months: ["Jan", "Fev", "Mar", "Abr", "Mai", "Jun", "Jul", "Ago", "Set", "Out", "Nov", "Dez"],
      monthsShort: ["Jan", "Fev", "Mar", "Abr", "Mai", "Jun", "Jul", "Ago", "Set", "Out", "Nov", "Dez"]
    },
    formatter: {
      date: function (date, settings) {
        if (date) {
          return date.toLocaleDateString({
            year: "numeric",
            month: "2-digit",
            day: "2-digit"
          });
        }
      }
    }
  });

  $('.ui.dropdown').dropdown();
})();