def deploy(version) {
    echo "Deploying version: $version"
}

def test() {
    echo "Testing the application..."
}

def build() {
    echo "Building the application..."
    echo "Building version: $params.VERSION"
}

return this