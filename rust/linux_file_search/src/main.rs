use std::io;
use std::path::Path;

fn main() {
    println!("Enter a term to search for");

    let mut search_term = String::new();
    io::stdin()
        .read_line(&mut search_term)
        .expect("Please enter a valid string");

    println!("Enter a directory to search through");

    let mut directory = String::new();
    io::stdin()
        .read_line(&mut directory)
        .expect("Please enter a valid string");

    let res = Path::new(&mut directory)
        .is_dir()
        .then(|| println!("The directory: is valid"));

    println!("Recurse search Y/n");
}
