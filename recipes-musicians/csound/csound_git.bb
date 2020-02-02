SUMMARY = "A sound and music computing system"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=a6f89e2100d9b6cdffcea4f398e37343"

inherit cmake gettext python3native

# TBD: fltk is not propely detected
DEPENDS += " \
    flex-native \
    bison-native \
    swig-native \
    python \
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
    git://github.com/csound/csound.git \
    file://0001-Do-not-set-include-path-to-usr-local-include.patch \
    file://0002-Do-not-use-try_run-for-portaudio.patch \
"
SRCREV = "297845a370b8b5e1b555a60a0be3c5c757599530"
S = "${WORKDIR}/git"
PV = "6.13.0"

# Where to get lua-version from?
LUA_VERSION = "5.3"

EXTRA_OECMAKE += " \
    -DUSE_DOUBLE=OFF \
    -DPYTHON_MODULE_INSTALL_DIR=${PYTHON_SITEPACKAGES_DIR} \
    -DUSE_LIB64=${@bb.utils.contains("baselib", "lib64", "ON", "OFF",d)} \
"

PACKAGECONFIG ??= "${@bb.utils.filter('DISTRO_FEATURES', 'pulseaudio', d)}"
PACKAGECONFIG[pulseaudio] = "-DUSE_PULSEAUDIO=ON,-DUSE_PULSEAUDIO=OFF,pulseaudio,pulseaudio-server"
PACKAGECONFIG[luajit] = "-DLUA_MODULE_INSTALL_DIR=${libdir}/lua/${LUA_VERSION},,luajit"

PACKAGES =+ " \
    ${PN}-python \
    ${PN}-luajit \
"

FILES_${PN}-python = "${PYTHON_SITEPACKAGES_DIR}"
RDEPENDS_${PN}-python += "python3-core"

FILES_${PN}-luajit = "${libdir}/lua"
