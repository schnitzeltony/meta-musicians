SUMMARY = "A sound and music computing system"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=a6f89e2100d9b6cdffcea4f398e37343"

inherit cmake gettext python3native

# TBD: fltk is not propely detected
DEPENDS += " \
    flex-native \
    bison-native \
    swig-native \
    python3 \
    alsa-lib \
    libsndfile1 \
    portaudio-v19 \
    portmidi \
    fluidsynth \
    curl \
    fltk \
    liblo \
    stk \
    libvorbis \
    libeigen \
    libwebsockets \
"

SRC_URI = " \
    git://github.com/csound/csound.git;branch=develop;protocol=https \
    file://0001-Do-not-set-include-path-to-usr-local-include.patch \
    file://0002-use-standard-plugins-path.patch \
"
SRCREV = "18c2c7897425f462b9a7743cee157cb410c88198"
S = "${WORKDIR}/git"
PV = "6.15.0"

# Where to get lua-version from?
LUA_VERSION = "5.3"

EXTRA_OECMAKE += " \
    -DUSE_DOUBLE=OFF \
    -DPYTHON_MODULE_INSTALL_DIR:STRING=${PYTHON_SITEPACKAGES_DIR} \
    -DPYTHON3_MODULE_INSTALL_DIR:STRING=${PYTHON_SITEPACKAGES_DIR} \
    -DUSE_LIB64=${@bb.utils.contains("baselib", "lib64", "ON", "OFF",d)} \
"

PACKAGECONFIG ??= "${@bb.utils.filter('DISTRO_FEATURES', 'pulseaudio', d)}"
PACKAGECONFIG[pulseaudio] = "-DUSE_PULSEAUDIO=ON,-DUSE_PULSEAUDIO=OFF,pulseaudio,pulseaudio-server"
PACKAGECONFIG[luajit] = "-DLUA_MODULE_INSTALL_DIR=${libdir}/lua/${LUA_VERSION},,luajit"

PACKAGES =+ " \
    ${PN}-python \
    ${PN}-luajit \
    ${PN}-samples \
"

FILES:${PN}-python = "${PYTHON_SITEPACKAGES_DIR}"
RDEPENDS:${PN}-python += "python3-core"

FILES:${PN}-luajit = "${libdir}/lua"

FILES:${PN}-samples = "${datadir}/samples"

