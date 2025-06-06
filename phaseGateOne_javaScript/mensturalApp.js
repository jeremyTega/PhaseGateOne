const prompt = require('prompt-sync')()
function startDate(year, month, day) {
    try {
        const date = new Date(year, month - 1, day);
        if (date.getDate() !== day) throw new Error('Invalid date');
        return date;c

    } catch (e) {
        console.error(`Invalid date: ${e.message}`);
        return null;
    }
}


function predictOvulationPeriod(startDate) {
    const ovulationDates = [];
    for (let i = 14; i <= 19; i++) {
        const ovulationDay = new Date(startDate);
        ovulationDay.setDate(startDate.getDate() + i);
        ovulationDates.push(ovulationDay);
    }
    return ovulationDates;
}


function safePeriods(startDate) {
    const safeDates = [];
    for (let i = 6; i <= 9; i++) {
        const safeDay = new Date(startDate);
        safeDay.setDate(startDate.getDate() + i);
        safeDates.push(safeDay);
    }
    return safeDates;
}


const day = Number(prompt("Enter the day your menstrual flow starts (1–31):"));
const month = Number(prompt("Enter the month your menstrual flow starts (1–12):"));
const year = Number(prompt("Enter the year your menstrual flow starts (e.g., 2025):"));

const start = startDate(year, month, day);

    console.log(`Your menstrual cycle starts on: ${start.toLocaleDateString()}`);
    console.log("Your possible ovulation period is:");
    const ovulationDates = predictOvulationPeriod(start);
    for (let i = 0; i < ovulationDates.length; i++) {
        console.log(ovulationDates[i].toLocaleDateString());
    }

    console.log("Your safe periods are:");
    const safeDates = safePeriods(start);
    for (let i = 0; i < safeDates.length; i++) {
        console.log(safeDates[i].toLocaleDateString());
    }


